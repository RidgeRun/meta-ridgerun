SUMMARY = "GStreamer Interpipe"
DESCRIPTION = "GStreamer plug-in that allows communication between two independent pipelines"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstInterpipe"
SECTION = "multimedia"
LICENSE = "LGPL2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=3191ae9476980e87e3494d2d8ebe4584"

# Base dependencies
DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gtk-doc-native \
    pkgconfig-native \
    "

# Source code configuration
SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/RidgeRun/gst-interpipe.git;protocol=https;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"

# Package file definitions
FILES:${PN} += "${libdir}/gstreamer-1.0/libgstinterpipe.so"

# Meson build options
EXTRA_OEMESON = "-Denable-gtk-doc=false"

# Inherit necessary classes
inherit meson
