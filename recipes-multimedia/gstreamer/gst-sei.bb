SUMMARY = "GStreamer SEI Plugin"
DESCRIPTION = "GStreamer plugin to add meta-data as SEI NAL units"
HOMEPAGE = "https://www.ridgerun.com/gstseimetadata"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../COPYING;md5=d28c53f3a5ec6efa235f27afaaa18be1"


DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    gobject-introspection-native \
    "

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
# Note: This SRC_URI points to RidgeRun's internal repository. Should
# replace it with the repository URI provided to them upon purchase of the plugin.
SRC_URI = "git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-sei.git;protocol=ssh;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/libgstsei.so \
    ${libdir}/girepository-1.0/GstSei-1.0.typelib \
    ${datadir}/gir-1.0/GstSei-1.0.gir \
    "

# Package configuration options
PACKAGECONFIG ??= ""
PACKAGECONFIG[doc] = "-Ddoc=enabled,-Ddoc=disabled,python3-hotdoc-native"
PACKAGECONFIG[examples] = "-Dexamples=enabled,-Dexamples=disabled"
PACKAGECONFIG[tests] = "-Dtests=enabled,-Dtests=disabled"

# Meson build options
EXTRA_OEMESON = "-Ddeveloper-mode=false"

# Inherit necessary classes
inherit meson pkgconfig

# Package configuration
PACKAGES_DYNAMIC = "^libsei.*"
INSANE_SKIP:${PN} = "dev-so"
