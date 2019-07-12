SUMMARY="GstOpenCL Plugin"
DESCRIPTION = "GstOpenCL plugin"
SECTION = "multimedia"
LICENSE = "Proprietary"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad imx-gst1.0-plugin"

#######
#Note repo is private. SSH keys are needed to do_fetch
#Please add the SRCREV and CUSTOMER according to the information
#provided by Ridgerun with your order.
#######
SRCBRANCH ?= "master"
SRCREV = "" 
CUSTOMER = 
SRC_URI = " git://git@gitlab.com/RidgeRun/orders/${CUSTOMER}/gst-opencl.git;protocol=ssh;branch=${SRCBRANCH}"


#S = "${WORKDIR}/gst-opencl-${PV}"
S = "${WORKDIR}/git"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/gstreamer-1.0/libgstopencl.so"
FILES_${PN} += "${libdir}/libgstopencl.so{,.0.0.0,.0}"
FILES_${PN} += "${libdir}/libgstopencl.so"

inherit autotools pkgconfig gettext

do_configure() {
  ${S}/autogen.sh
  oe_runconf
}

#To avoid error related to package contains symlink .so
INSANE_SKIP_${PN} = "dev-so"

do_install_append() {
  #To avoid error related to installed but not shipped libgstopencl.a file
  rm -f ${D}/usr/lib/gstreamer-1.0/libgstopencl.a
}

