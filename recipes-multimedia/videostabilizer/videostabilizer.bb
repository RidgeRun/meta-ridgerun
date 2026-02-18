SUMMARY = "Video Stabilizer for Embedded Systems"
DESCRIPTION = "RR Video Stabilizer is a project from RidgeRun Engineering that provides \
real-time camera stabilization for embedded systems with constrained resources \
"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Video_Stabilization_for_Embedded_Systems"
SECTION = "multimedia"
LICENSE = "CLOSED"

BRANCH ?= "develop"
SRCREV = "d91fcbb463240d402743fe2d609c47cf5f2406c1"
SRC_URI = "<customer-repository-rvs>"
SRC_URI[sha256sum] = "ef8113f85c1bf55c080240982c0791e65941f26c373da8645bc48462c3f70d1e"

S = "${WORKDIR}/git"

DEPENDS = "\
    opencv \
    glm \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    gstcameradrivermeta \
"
RDEPENDS:${PN}:append = "\
    opencv \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    gstcameradrivermeta \
"

EXTRA_OEMESON:append = "\
    -Ddeveloper-mode=false \
    -Denable-docs=disabled \
    -Denable-tests=disabled \
    -Denable-examples=enabled \
    -Denable-plots=false \
    -Denable-opencv=enabled \
    -Denable-opencl=enabled \
    -Denable-gstreamer=enabled \
    -Denable-cuda=disabled \
    --optimization 3 \
    --prefix ${prefix} \
"

LDFLAGS[unexport] = "1"
INSANE_SKIP = "rpaths"
EXEWRAPPER_ENABLED:class-target = "False"

inherit meson pkgconfig

FILES:${PN}:append = "\
    ${libdir}/gstreamer-1.0/*.so* \
"
