SUMMARY = "GstOpenCL Plugin"
DESCRIPTION = "GstOpenCL plugin"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../COPYING;md5=d28c53f3a5ec6efa235f27afaaa18be1"

DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    imx-gst1.0-plugin \
"

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"

SRC_URI = "git://git@gitlab.ridgerun.com/ridgerun/orders/${RR_CUSTOMER_GITLAB_ORDER_DIR}/gst-opencl.git;protocol=ssh;user=git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

FILES_SOLIBSDEV = ""

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/libgstopencl.so \
    ${libdir}/libgstopencl.so \
    ${libdir}/libgstopencl.so.0 \
    ${libdir}/libgstopencl.so.0.0.0 \
"

inherit autotools pkgconfig gettext

do_configure() {
    ${S}/autogen.sh
    oe_runconf
}

# To avoid QA error related to package containing symlink .so
INSANE_SKIP:${PN} = "dev-so"

do_install:append() {
    # Avoid QA error for installed-but-not-shipped static library
    rm -f ${D}${libdir}/gstreamer-1.0/libgstopencl.a
}
