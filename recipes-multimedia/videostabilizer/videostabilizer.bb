SUMMARY = "video stabilizer"
DESCRIPTION = "RR Video Stabilizer is a project from RidgeRun Engineering that provides real-time camera stabilization for embedded systems with constrained resources"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Video_Stabilization_for_Embedded_Systems"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=40d5a41acc8b978360b558aae1277a97"
DEPENDS = " ffmpeg glm gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"
EXTRA_OEMESON += " -Dtests=disabled -Dexamples=disabled"
EXTRA_OECMAKE = " \
-Dtests=disabled \
"
SRCBRANCH ?= "feature/fix-meson-option"
SRCREV = "63fb24d622fff7d768f1c4daf72236cb456e589c"
SRC_URI = " git://git@gitlab.com/RidgeRun/rnd/video-stabilizer.git;protocol=ssh;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"
inherit meson pkgconfig
FILES_${PN} += " ${libdir}/usr/local/lib/libvideostabilizer.so"
