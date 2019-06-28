SUMMARY = "RidgeRun's Inference Library"
DESCRIPTION = "A machine learning library for easy inference integration"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=R2Inference"
SECTION = "multimedia"
LICENSE = "LGPL2.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=2b556d5ad20b1a7c92b8c9ba648c34ed"

DEPENDS = "prebuilt-tensorflow"

SRCBRANCH ?= "master"
SRCREV = "08b6d8d033c301d8acb109d1698a956da1749d14"
SRC_URI = "git://github.com/RidgeRun/r2inference;protocol=https;branch=${SRCBRANCH}"

EXTRA_OECONF += " --disable-tests --disable-docs --enable-tensorflow"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/libr2inference.so"

inherit autotools pkgconfig gettext
