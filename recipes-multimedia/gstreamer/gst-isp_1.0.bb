SUMMARY = "Gst-ISP plugin"
DESCRIPTION = "Gst-ISP plugin"
SECTION = "multimedia"
LICENSE = "CLOSED"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gst-opencl"

#SRC_URI = "file://gst-isp-0.1.tar.gz"
SRCBRANCH ?= "dev-0.1"
SRCREV = "3f3f692fb1202f00fa5702c4415628b27448d512"
SRC_URI = "git://github.com/RidgeRun/gst-isp.git;protocol=ssh;branch=${SRCBRANCH}"


#S = "${WORKDIR}/gst-isp-0.1"
S = "${WORKDIR}/git"

FILES_${PN} += "/usr/lib/gstreamer-1.0/libgstisp.so /usr/lib/libgstisp.so{,.0.0.0,.0}"

EXTRA_OECONF += " --disable-tests"

inherit autotools pkgconfig gettext

do_install_append() {
  #To avoid error related to installed but not shipped libgstisp.a file
  rm -f ${D}/usr/lib/gstreamer-1.0/libgstisp.a
}

