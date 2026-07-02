SUMMARY = "RidgeRun Video Stabilization Library and GStreamer plugin"
DESCRIPTION = "RidgeRun Video Stabilization Library with optional OpenCV/OpenCL/CUDA backends and GStreamer support"
HOMEPAGE = "https://gitlab.ridgerun.com/ridgerun/rnd/ridgerun-video-stabilizer"
SECTION = "multimedia"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://docs/style/LICENSE;md5=c9084e6d047cbfac6a2587328128df18"

SRC_URI = "gitsm://git@gitlab.ridgerun.com/ridgerun/rnd/ridgerun-video-stabilizer.git;protocol=ssh;branch=main"

PV = "1.0+git"
SRCREV = "886d395da4dee08a027913dd62c3ce403965a52a"

S = "${WORKDIR}/git"

inherit meson pkgconfig

B = "${WORKDIR}/build"
EXTERNALSRC_BUILD = "${B}"

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    libgudev \
    v4l-utils \
    opencv \
    gstcameradrivermeta"

RDEPENDS:${PN} += " gstcameradrivermeta"

EXTRA_OEMESON += " \
    --optimization=3 \
    -Ddeveloper-mode=false \
    -Denable-docs=disabled \
    -Denable-tests=disabled \
    -Denable-examples=disabled \
    -Denable-plots=false \
    -Denable-gstreamer=enabled \
    -Denable-opencv=enabled \
    -Denable-opencl=disabled \
    -Denable-cuda=disabled \
    -Denable-gstreamer=enabled \
"

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/*.so \
    ${libdir}/*.so.* \
"

FILES:${PN}-dev += " \
    ${includedir} \
    ${libdir}/pkgconfig/*.pc \
"
