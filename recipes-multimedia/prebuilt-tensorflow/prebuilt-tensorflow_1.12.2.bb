SUMMARY = "TensorFlow Binaries"
DESCRIPTION = "Prebuilt TensorFlow V1.12.2 binaries for i.MX8 boards"
SECTION = "libs"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

#Binary from RidgeRun's store
BINARY_NAME = "imx8-cpu-libtensorflow"

SRC_URI = "file://${BINARY_NAME}.tar.gz"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${includedir}/tensorflow/c/eager/
	install -d ${D}${libdir}/
	install -m 0755 ${S}/include/tensorflow/c/c_api* ${D}${includedir}/tensorflow/c/
	install -m 0755 ${S}/include/tensorflow/c/eager/c_api* ${D}${includedir}/tensorflow/c/eager/
	install -m 0755 ${S}/lib/libtensorflow* ${D}${libdir}/
}

do_package_qa[noexec] = "1"

FILES_${PN} += "${libdir}/"
FILES_${PN} += "/usr/lib/libtensorflow_framework.so"
FILES_${PN} += "/usr/lib/libtensorflow.so"
FILES_${PN} += "/usr/include/tensorflow/c/c_api.h"
FILES_${PN} += "/usr/include/tensorflow/c/c_api_experimental.h"
FILES_${PN} += "/usr/include/tensorflow/c/eager/c_api.h"

PACKAGES = "${PN}"
