# meta-ridgerun

Ridgerun yocto layer containing RidgeRun commonly used packages

## Adding meta-ridgerun to your Yocto build

- First you need to copy meta-ridgerun in your **sources** directory
```
cp -r meta-ridgerun $YOCTO_DIRECTORY/sources/
```

- Then add the RidgeRun meta layer to your *bblayers.conf* file. First go to the build configuration directory
```
cd $YOCTO_DIRECTORY/build/conf/
```

- Open the *bblayers.conf* file and add the RidgeRun meta layer path **$YOCTO_DIRECTORY/sources/meta-ridgerun** to **BBLAYERS**

- With these steps the meta-ridgerun layer was added correctly

## Building Gst-Shark and Gstreamer Deamon

- Go to your yocto directory and export the machine used. For example:
```
export MACHINE=zcu106-zynqmp
```

- Finally build both recipes
```
bitbake gstd gst-shark
```