SUMMARY = "RidgeRun custom V4L2 source GStreamer plugin"
DESCRIPTION = "Custom RidgeRun V4L2 source plugin with timestamp metadata support"
SECTION = "multimedia"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=c71b653a0f608a58cdc5693ae57126bc"

BRANCH ?= "feature/add-timestamp-metadata"
SRC_URI = "git://gitlab.ridgerun.com/open/gstreamer/gst-v4l2src.git;protocol=https;branch=${BRANCH} \
           file://0001-meson-avoid-gstreamer-plugins-good-pkg-config-depend.patch \
           "

PV = "1.0+git"
SRCREV = "8885d5c60d0adc9c71ab7134d59e1546d54b817c"

S = "${WORKDIR}/git"

inherit meson pkgconfig

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    libgudev \
    v4l-utils \
    gstcameradrivermeta \
"

RDEPENDS:${PN} += "gstcameradrivermeta v4l-utils kernel-module-uvcvideo"

FILES:${PN} += " \
${libdir}/gstreamer-1.0/*.so \
"
 
