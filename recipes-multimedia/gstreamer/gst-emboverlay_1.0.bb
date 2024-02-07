SUMMARY = "Embedded Overlay"
DESCRIPTION = "GStreamer element used to overlay images and text over video streams"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php/Fast_GStreamer_overlay_element"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base cairo"

SRCBRANCH ?= "master"
SRCREV = "542f26d60e3b0b0e7ef9d4438096e57773a2dd34"
SRC_URI = " git://git@gitlab.ridgerun.com/RidgeRun/orders/<Customer-Directory>/gst-emboverlay.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/src"

FILES:${PN} += "\
        ${libdir}/gstreamer-1.0/libgstemboverlay.so \
        ${libdir}/gstreamer-1.0/libgstemboverlay.la \
"

inherit autotools pkgconfig gettext
