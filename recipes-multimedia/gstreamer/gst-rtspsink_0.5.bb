SUMMARY = "GstRtspSink"
DESCRIPTION = "GStreamer element which permits high performance streaming to multiple computers using the RTSP / RTP protocols"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstRtspSink"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base libffi gstreamer1.0-rtsp-server"

SRCBRANCH ?= "master"
SRCREV = "41daff12b5e1c6bf809bff806bf6cde77a3b7561"
SRC_URI = "git://git@github.com/RidgeRun/orders/<Customer-Directory>/gst-rtspsink.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
  	${libdir}/gstreamer-1.0/libgstrtspsink.la \
	${libdir}/gstreamer-1.0/libgstrtspsink.so \
"

inherit autotools pkgconfig gettext
