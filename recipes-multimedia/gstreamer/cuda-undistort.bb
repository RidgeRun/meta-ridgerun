SUMMARY = "RidgeRun CUDA-Undistort GStreamer plugin"
DESCRIPTION = "A GStreamer plugin to undistort images using CUDA as the backend"
HOMEPAGE = "https://www.ridgerun.com/gstcudaundistort"
SECTION = "multimedia"

LICENSE = "CLOSED"

SRCBRANCH ?= "main"
SRCREV = "${AUTOREV}"

# Note: This SRC_URI points to RidgeRun's internal repository. Should
# replace it with the repository URI provided to them upon purchase of the plugin.
SRC_URI = " \
    gitsm://gst-cuda-repository;protocol=ssh;branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

inherit meson cuda pkgconfig

DEPENDS = " \
    cuda-toolkit-native \
    cuda-cudart-native \
    glib-2.0 \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    tegra-mmapi \
    gst-cuda \
    opencv \
"

EXTRA_OEMESON:append = " \
    --buildtype=release \
    -Denable-eval=false \
"

INSANE_SKIP = "rpaths"
LDFLAGS[unexport] = "1"
EXEWRAPPER_ENABLED:class-target = "False"

RDEPENDS:${PN}:append = " \
    gst-cuda \
"

FILES:${PN} += "${libdir}/gstreamer-1.0/"
