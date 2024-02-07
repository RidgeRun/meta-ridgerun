SUMMARY="GstOpenCL Plugin"
DESCRIPTION = "GstOpenCL plugin"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=46819161aba98ab8c502e93a15713e58"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad opencl-headers opencl-icd-loader "

#######
#Note repo is private. SSH keys are needed to do_fetch
#Please add the SRCREV and CUSTOMER according to the information
#provided by Ridgerun with your order.
#######
SRCBRANCH ?= "master"
SRCREV = "fbb0874e9078e9318c0086a87465bd6188360bcb"
SRC_URI = " git://git@gitlab.ridgerun.com/RidgeRun/orders/${CUSTOMER}/gst-opencl.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"


inherit autotools pkgconfig gettext

do_configure() {
  ${S}/autogen.sh
  oe_runconf
}

#To avoid error related to package contains symlink .so
INSANE_SKIP_${PN} = "dev-so"
FILES:${PN} += "${libdir}/libgstopencl.so.0.0.0 ${libdir}/gstreamer-1.0/libgstopencl.so ${libdir}/libgstopencl.so.0 ${libdir}/libgstopencl.so "
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_install:append() {
  #To avoid error related to installed but not shipped libgstopencl.a file
  rm -f ${D}/usr/lib/gstreamer-1.0/libgstopencl.a
  rm -f ${D}/usr/lib/libgstopencl.so
  cp ${D}/usr/lib/libgstopencl.so.0.0.0 ${D}/usr/lib/libgstopencl.so
}
