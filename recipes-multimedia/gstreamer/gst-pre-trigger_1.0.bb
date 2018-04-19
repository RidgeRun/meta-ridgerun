SUMMARY = "PreTriger"
DESCRIPTION = "GStreamer element that pre-records data continuously into a FIFO"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GStreamer_pre-record_element"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

SRCBRANCH ?= "master"
SRCREV = "64ae60cc8bc10bc75bc464da71d325a7147d089e"
SRC_URI = " git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-pre-trigger.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
        ${libdir}/gstreamer-1.0/libgstpretrigger.so \
        ${libdir}/gstreamer-1.0/libgstpretrigger.la \
"

inherit autotools pkgconfig gettext