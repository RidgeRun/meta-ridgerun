!/bin/bash

echo "Welcome to meta-ridgerun setup script!"
echo "Please mark with yes (y) the recipes you want in your image"

# Get the name of all available recipes, except the ones from images
recipes=`find . -name *.bb | sed -e 's,\.\/,,' -e '/recipes-images/d'`
conf_recipes=""
conf_packages=""
prop_recipes=()

# Ask for every recipe in the directory
for recipe in $recipes; do
    while true; do
        recipe_name=`basename $recipe`
        package_name=`echo $recipe_name | sed -e 's,_[0-9]\+.[0-9]\+.*[0-9]*.bb,,'`
        read -p "Do you wish to add the $recipe_name recipe (y/n): " answer
        case $answer in
            [Yy]* ) conf_recipes+="\${LAYERDIR}/$recipe "; conf_packages+="PACKAGE$package_name "; break;;
            [Nn]* ) break;;
            * ) echo "Please answer yes (y) or no (n).";;
        esac
    done
done

# Print summary for confirmation
echo -e "Packages that will be added:\n`echo $conf_packages | sed -e 's,PACKAGE,*,g' -e 's, ,\n,g'`"
while true; do
    read -p "Confirm selection (y/n): " answer
    case $answer in
        [Yy]* ) break;;
        [Nn]* ) echo "Not adding packages, please run the setup script again"; exit 0;;
        * ) echo "Please answer yes (y) or no (n).";;
    esac
done

# Modify the layer.conf and core-image-ridgerun.bb files according to selection
sed -i -e "s,<RECIPES>,${conf_recipes}," -e 's,\${LAYERDIR}\/recipes,\\\n  \${LAYERDIR}\/recipes,g' conf/layer.conf
sed -i -e "s,<PACKAGES>,${conf_packages}," -e 's,PACKAGE,\\\n  ,g' recipes-images/images/core-image-ridgerun.bb
conf_recipes=(`echo $conf_recipes | sed -e 's,\${LAYERDIR}\/,,g'`)
conf_packages=(`echo $conf_packages | sed -e 's,PACKAGE,,g'`)

echo "The packages have been sucessfully added to conf/layer.conf and recipes-images/images/core-image-ridgerun.bb"

# Check if the selected packages are among the proprietary ones
PROPRIETARY="pcie-fpga-v4l2 gst-emboverlay gst-isp gst-motiondetect gst-opencl gst-pre-record gst-qt-overlay gst-rtsp-sink gst-uvc-sink gst-webrtc libguvc videostabilizer"

for (( i=0; i<${#conf_recipes[@]}; i++ )); do
    echo "$PROPRIETARY" | grep -q "${conf_packages[$i]}" && prop_recipes+=(${conf_recipes[$i]})
done

if [ ${#prop_recipes[@]} -ge 1 ]; then
    echo -e "\nWARNING: Please add a valid SRC_URI for the following recipe(s) before running bitbake:\n*`echo ${prop_recipes[@]} | sed -e 's, ,\n*,g'`"
fi

echo "You may now add meta-ridgerun to your bblayers.conf"
