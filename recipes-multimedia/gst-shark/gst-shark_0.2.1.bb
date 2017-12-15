DESCRIPTION = "RidgeRun Gst-Shark Tracers" 
SECTION = "multimedia" 
LICENSE = "GPLv2+" 
LIC_FILES_CHKSUM = "file://COPYING;md5=e1caa368743492879002ad032445fa97" 

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad "

SRCBRANCH ?= "master"
SRCREV = "37e27a830903537a1cb585813ba8e1f9f2e9501a"
SRC_URI = "git://git@github.com/RidgeRun/gst-shark.git;protocol=ssh;branch=${SRCBRANCH}"

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
