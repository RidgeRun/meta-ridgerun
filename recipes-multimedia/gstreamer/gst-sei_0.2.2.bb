SUMMARY = "GStreamer SEI"
DESCRIPTION = "GStreamer element to insert and extract metadata on NAL Units"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstSEIMetadata"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=2207b8e5f4ab4b3a0c794e43f2002ea3"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

SRCTAG ?= "v${PV}"
SRC_URI = " git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-sei.git;protocol=ssh;tag=${SRCTAG}"

FILES_${PN} += "\
        ${libdir}/gstreamer-1.0/libsei.so \
        ${libdir}/libgstsei.so \
"

S = "${WORKDIR}/git"

EXTRA_OEMESON = " -Ddoc=disabled -Dtests=disabled -Dexamples=disabled"

inherit meson pkgconfig

