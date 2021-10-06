SUMMARY = "Video Stabilizer for Embedded Systems"
DESCRIPTION = "RR Video Stabilizer is a project from RidgeRun Engineering that provides real-time camera stabilization for embedded systems with constrained resources"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Video_Stabilization_for_Embedded_Systems"
SECTION = "multimedia"
LICENSE = "Proprietary"
export prefix = "/usr"
libdir = "${prefix}/lib"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a7c41067a5fd2e6fdff3205c7e73ffc"
DEPENDS = " ffmpeg opencv glm gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"
EXTRA_OEMESON += " -Dtests=disabled -Denable-plots=false"
SRCBRANCH ?= "develop"
SRCREV = "d42d5196f78765c6a23e15d99b6b936de7a5f090"
SRC_URI = " git://git@gitlab.com/RidgeRun/rnd/video-stabilizer.git;protocol=ssh;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"
inherit meson pkgconfig
do_install_append () {
    install -d ${D}${bindir}
    install -m 0755 ${B}/tests/examples/videostabilizer_example ${D}${bindir}
}
FILES_${PN} += "${libdir}/gstreamer-1.0/libgstrrvideostabilizer.so ${libdir}/libvideostabilizer.so"
