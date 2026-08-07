SUMMARY = "RidgeRun Video Stabilization Library and GStreamer plugin"
DESCRIPTION = "RidgeRun Video Stabilization Library with optional OpenCV/OpenCL/CUDA backends and GStreamer support"
SECTION = "multimedia"
LICENSE = "CLOSED"

SRCBRANCH ?= "master"
SRC_URI = "git://git@gitlab.ridgerun.com/ridgerun/orders/${RR_CUSTOMER_GITLAB_ORDER_DIR}/ridgerun-video-stabilizer.git;protocol=ssh;branch=${SRCBRANCH}"

PV = "1.0+git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig

# meta-tegra adds the "cuda" override for all Jetson machines. Only inherit
# its CUDA helper when that override is active so this layer remains usable
# without meta-tegra for non-CUDA targets.
inherit ${@'cuda' if 'cuda' in d.getVar('OVERRIDES').split(':') else ''}

# meta-tegra supplies nvcc through this extra Meson cross file. CUDA compiler
# sanity binaries target the Jetson and cannot run on the x86 build host.
meson_cuda_cross_config() {
    cat >${WORKDIR}/meson-cuda.cross <<EOF
[binaries]
cuda = 'nvcc'

[properties]
skip_sanity_check = true
EOF
}

B = "${WORKDIR}/build"
EXTERNALSRC_BUILD = "${B}"

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    libgudev \
    opencv \
    glm \
    gstcameradrivermeta \
    "

DEPENDS:append:cuda = " \
    tegra-libraries-cuda \
    tegra-cuda-utils \
    "

RDEPENDS:${PN} += " gstcameradrivermeta"

PACKAGECONFIG ??= "opencl"
PACKAGECONFIG:cuda = "cuda"

PACKAGECONFIG[cuda] = "-Denable-cuda=enabled,-Denable-cuda=disabled,cuda-cudart"
PACKAGECONFIG[opencl] = "-Denable-opencl=enabled,-Denable-opencl=disabled,opencl-headers virtual/opencl-icd"

EXTRA_OEMESON += " \
    --optimization=3 \
    -Ddeveloper-mode=false \
    -Denable-docs=disabled \
    -Denable-tests=disabled \
    -Denable-examples=disabled \
    -Denable-plots=false \
    -Denable-gstreamer=enabled \
    -Denable-opencv=enabled \
"

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/*.so \
    ${libdir}/*.so.* \
"

FILES:${PN}-dev += " \
    ${includedir} \
    ${libdir}/pkgconfig/*.pc \
"
