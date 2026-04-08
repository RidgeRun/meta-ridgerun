SUMMARY = "GstRtspSink"
DESCRIPTION = "GStreamer element which permits high performance streaming to multiple computers using the RTSP / RTP protocols"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstRtspSink"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    libffi \
    gstreamer1.0-rtsp-server \
    "

SRCBRANCH ?= "master"
SRCREV = "00ba80901c2fef77822f6e3d14dc82088b70434f"

SRC_URI = "git://git@gitlab.ridgerun.com/ridgerun/orders/${RR_CUSTOMER_GITLAB_ORDER_DIR}/gst-rtsp-sink.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/src"

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/libgstrtspsink.so \
    ${libdir}/gstreamer-1.0/libgstrtspsink.la \
    "

inherit autotools pkgconfig gettext rr_proprietary

INSANE_SKIP:${PN} += "dev-so"
