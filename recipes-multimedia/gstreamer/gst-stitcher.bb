SUMMARY = "RidgeRun Stitching framework for image stitching with CUDA support"
DESCRIPTION = "Framework to perform stitching of different input images with CUDA backend support"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php/Image_Stitching_for_NVIDIA_Jetson/Getting_Started/Evaluating_the_Stitcher"
SECTION = "multimedia"
LICENSE = "CLOSED"

SRCBRANCH ?= "main"
SRCREV = "${AUTOREV}"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

#TODO:Change the SRC_URI to point the actual repository of gst-stitcher
SRC_URI = " \
    git://gst-cuda-stitcher-repository;protocol=ssh;branch=${SRCBRANCH} \
    file://gstcudastitcher.patch \
"

S = "${WORKDIR}/git"

inherit meson cuda pkgconfig

DEPENDS = " \
    cuda-toolkit-native \
    cuda-cudart-native \
    glib-2.0 \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gst-cuda \
    opencv \
    cpputest \
    gtk+ \
    pre-commit-native \
    pkgconfig-native \
    jsoncpp \
"

PACKAGECONFIG ??= "gst-stitcher ocvcuda profile-code nvmm"
PACKAGECONFIG[tests] = "-Dtests=enabled,-Dtests=disabled"
PACKAGECONFIG[examples] = "-Dexamples=enabled,-Dexamples=disabled"
PACKAGECONFIG[ocvcuda] = "-Docvcuda=enabled,-Docvcuda=disabled"
PACKAGECONFIG[profile-code] = "-Dprofile-code=enabled,-Dprofile-code=disabled"
PACKAGECONFIG[gst-stitcher] = "-Dgst-stitcher=enabled,-Dgst-stitcher=disabled"
PACKAGECONFIG[eval] = "-Deval=enabled,-Deval=disabled"
PACKAGECONFIG[nvmm] = "-Denable-nvmm=true,-Denable-nvmm=false"
PACKAGECONFIG[developer-mode] = "-Ddeveloper-mode=true,-Ddeveloper-mode=false"

EXTRA_OEMESON += " --buildtype=release"

RDEPENDS:${PN} += "gst-cuda"

INSANE_SKIP:${PN} = "rpaths"
LDFLAGS[unexport] = "1"
EXEWRAPPER_ENABLED:class-target = "False"

FILES:${PN} += "${libdir}/gstreamer-1.0/*.so*"
