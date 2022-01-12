#!/bin/bash

injected_dir=$1
echo "Installing Driver into the Image. Injected-dir="$injected_dir

source /usr/local/s2i/install-common.sh
install_modules ${injected_dir}/modules
configure_drivers ${injected_dir}/drivers.env
