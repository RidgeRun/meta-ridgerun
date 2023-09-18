SUMMARY = "Gst-ISP plugin"
DESCRIPTION = "Gst-ISP plugin"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=46819161aba98ab8c502e93a15713e58"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gst-opencl"

#######
#Note repo is private. SSH keys are needed to do_fetch
#Please add the SRCREV and CUSTOMER according to the information
#provided by Ridgerun with your order.
#######

SRCBRANCH ?= "master"
SRCREV = "bee5ab4803d7e58cdaa610460e5c520468f15888"
CUSTOMER = ""
SRC_URI = " git://git@gitlab.com/${CUSTOMER}/gst-isp.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

FILES:${PN} += " ${libdir}/gstreamer-1.0/libgstisp.so "
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

EXTRA_OECONF += " --disable-tests "

inherit autotools pkgconfig gettext
