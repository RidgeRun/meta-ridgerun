SUMMARY="GstOpenCL Plugin"
DESCRIPTION = "GstOpenCL plugin"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=46819161aba98ab8c502e93a15713e58"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-plugins-imx"

#######
#Note repo is private. SSH keys are needed to do_fetch
#Please add the SRCREV and CUSTOMER according to the information
#provided by Ridgerun with your order.
#######

SRCBRANCH ?= "master"
SRCREV = "0893016e217ab27a4703a89b9a0355cee84809b7"
CUSTOMER = ""
SRC_URI = " git://git@gitlab.ridgerun.com/${CUSTOMER}/gst-opencl.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

#EXTRA_OECONF += " --enable-eval "

inherit autotools pkgconfig gettext

do_configure() {
  ${S}/autogen.sh
  oe_runconf
}

#To avoid error related to package contains symlink .so
INSANE_SKIP:${PN} = "dev-so dev-elf"

FILES:${PN} += "${libdir}/libgstopencl.so.0.0.0 ${libdir}/gstreamer-1.0/libgstopencl.so ${libdir}/libgstopencl.so.0 ${libdir}/libgstopencl.so"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
