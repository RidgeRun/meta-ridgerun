SUMMARY = "Gst-ISP plugin"
DESCRIPTION = "Gst-ISP plugin"
HOMEPAGE = "https://www.ridgerun.com/gstisp"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../COPYING;md5=d28c53f3a5ec6efa235f27afaaa18be1"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gst-opencl"

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git@gitlab.ridgerun.com/ridgerun/orders/${RR_CUSTOMER_GITLAB_ORDER_DIR}/gst-isp.git;protocol=ssh;user=git;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/libgstisp.so \
    ${libdir}/libgstisp.so \
    ${libdir}/libgstisp.so.0 \
    ${libdir}/libgstisp.so.0.0.0 \
"

EXTRA_OECONF += " --disable-tests --disable-developer"

inherit autotools pkgconfig gettext rr_proprietary

do_install:append() {
    # Avoid QA error for installed-but-not-shipped static library
    rm -f ${D}${libdir}/gstreamer-1.0/libgstisp.a
}
