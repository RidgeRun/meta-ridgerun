SUMMARY = "GStreamer Network Balancer Plugin"
DESCRIPTION = "GStreamer plugin to balance network packages to respect bandwidth over time"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstNetBalancer"
SECTION = "multimedia"

LICENSE = "CLOSED"

SRCBRANCH ?= "main"
SRCREV = "${AUTOREV}"

# Note: This SRC_URI points to RidgeRun's internal repository. Should
# replace it with the repository URI provided to them upon purchase of the plugin.
SRC_URI = " \
    git://gst-cuda-repository;protocol=ssh;branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    python3-native \
    ninja-native \
"

inherit meson pkgconfig

EXTRA_OEMESON = " \
    -Ddeveloper-mode=false \
    -Deval=disabled \
"

do_install:append() {
    install -d ${D}${libdir}/gstreamer-1.0
}

FILES:${PN} += "${libdir}/gstreamer-1.0/"
PACKAGES_DYNAMIC = "^libgstnetbalancer.*"
INSANE_SKIP:${PN} = "dev-so"


RDEPENDS:${PN} = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
"
