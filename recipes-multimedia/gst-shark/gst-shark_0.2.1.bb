DESCRIPTION = "RidgeRun Gst-Shark Tracers" 
SECTION = "multimedia" 
LICENSE = "GPLv2+" 
LIC_FILES_CHKSUM = "file://COPYING;md5=e1caa368743492879002ad032445fa97" 

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad "

SRCBRANCH ?= "master"
SRC_URI = " \
	git://git@github.com/RidgeRun/gst-shark.git;protocol=https;branch=${SRCBRANCH};name=base \
	git://git@anongit.freedesktop.org/gstreamer/common;protocol=https;destsuffix=git/common;name=common; \
	"

SRCREV_base = "64ca36ffc211d09059dec872ddab74de75af8a24"
SRCREV_common = "b64f03f6090245624608beb5d2fff335e23a01c0"

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
