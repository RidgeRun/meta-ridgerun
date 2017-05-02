DESCRIPTION = "GST Shark Tracer" 
SECTION = "multimedia" 
LICENSE = "GPLv2+" 
LIC_FILES_CHKSUM = "file://COPYING;md5=e1caa368743492879002ad032445fa97" 

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad "

SRCBRANCH ?= "master"
SRCREV = "fc0538d7fabee37a818e8538b04f5f7a7a1015bb"
SRC_URI = "git://git@github.com/RidgeRun/gst-shark.git;protocol=ssh;branch=${SRCBRANCH}"

#SRC_URI = "git://git@bitbucket.org/cmorgan/somerepository.git;protocol=ssh"

# SRC_URI = "git://github.com/Freescale/gstreamer-imx.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGECONFIG_CONFARGS = " \
	--disable-graphviz \
	--enable-gtk-doc=no \
"

FILES_${PN} += "\
	${libdir}/gstreamer-1.0/libgstsharktracers.so  \
	${libdir}/gstreamer-1.0/libgstsharktracers.la \
"

inherit autotools gettext 

do_configure() {
${S}/autogen.sh --noconfigure
oe_runconf
}

COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx6ul|mx6ull|mx7d)"
