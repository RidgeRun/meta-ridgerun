SUMMARY = "GStreamer Perf 1.0"
DESCRIPTION = "GStreamer element to measure fps and performance"
HOMEPAGE = "https://github.com/RidgeRun/gst-perf-autotools"
SECTION = "multimedia"
LICENSE = "LGPLv2"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

SRCBRANCH ?= "master"
SRCREV = "939eee167c6e95ed1c2f2013246b1f0b671a378b"
SRC_URI = "git://github.com/RidgeRun/gst-perf.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/gst-perf-${PV}"

INSANE_SKIP_${PN} = "dev-so"
FILES_${PN} += "${libdir}/gstreamer-1.0/libgstperf.so \
                ${libdir}/gstreamer-1.0/libgstperf.so.0 \
                ${libdir}/gstreamer-1.0/libgstperf.so.0.0.0 \
               "

inherit autotools pkgconfig gettext

do_configure() {
${S}/autogen.sh
oe_runconf
}
