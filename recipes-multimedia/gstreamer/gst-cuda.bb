SUMMARY = "RidgeRun GStreamer CUDA plug-in framework"
DESCRIPTION = "GstCUDA provides base classes and helper utilities to integrate CUDA algorithms into GStreamer 1.0 pipelines."
HOMEPAGE = "https://github.com/RidgeRun/gst-cuda"
SECTION = "multimedia"

LICENSE = "CLOSED"

SRCBRANCH ?= "main"
SRCREV = "${AUTOREV}"

# Note: This SRC_URI points to RidgeRun's internal repository. Should
# replace it with the repository URI provided to them upon purchase of the plugin.
SRC_URI = " \
    gitsm://gst-cuda-repository;protocol=ssh;branch=${SRCBRANCH} \
    file://0001-simplify-CUDA-library-detection-and-NVCC-flag-setup.patch \
"

S = "${WORKDIR}/git"

inherit autotools cuda pkgconfig

DEPENDS = " \
    cuda-toolkit-native \
    cuda-cudart-native \
    glib-2.0 \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    tegra-mmapi \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[gtk-doc]  = "--enable-gtk-doc,--disable-gtk-doc,gtk-doc-native"
PACKAGECONFIG[nvmm]     = "--enable-nvmm \
                           --with-nvidia-multimedia-api-prefix=${STAGING_INCDIR}/ \
                           --with-nvidia-prefix=${STAGING_LIBDIR}/ \
                           --with-nvidia-egl-prefix=${STAGING_LIBDIR}/, \
                           --disable-nvmm,"
PACKAGECONFIG[examples] = "--enable-examples,--disable-examples,"

FILES:${PN} += "${libdir}/gstreamer-1.0/"
