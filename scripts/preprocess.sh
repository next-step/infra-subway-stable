#!/bin/bash

## Variables
PROJECT_DIR="$HOME/infra-subway-stable"
LOGGING_DIR="$HOME/logs"
LOCAL_PEM_DIR="$HOME/pem"
PROJECT_PEM_DIR="$PROJECT_DIR/pem"
SCRIPT_DIR="$PROJECT_DIR/scripts"

## Colors
txtrst='\033[1;37m' # White
txtred='\033[1;31m' # Red
txtylw='\033[1;33m' # Yellow
txtpur='\033[1;35m' # Purple
txtgrn='\033[1;32m' # Green
txtgra='\033[1;30m' # Gray

add_line_crlf() {
  echo ""
}

permit_authority_scripts() {
  echo -e "${txtylw}=======================================${txtrst}"
  echo -e "${txtgrn} Permit scripts execution for other ${txtrst}"
  echo -e "${txtylw}=======================================${txtrst}"
  chmod u+x *
}

make_logging_directory() {
  echo -e "${txtylw}=======================================${txtrst}"
  echo -e "${txtgrn} Make logging Directory ${txtrst}"
  echo -e "${txtylw}=======================================${txtrst}"

  if [[ ! -d $LOGGING_DIR ]]; then
    mkdir "$LOGGING_DIR"
  fi

  add_line_crlf
}

#copy_nginx_pem_files() {
#  echo -e "${txtylw}=======================================${txtrst}"
#  echo -e "${txtgrn} Copy pem file for nginx ${txtrst}"
#  echo -e "${txtylw}=======================================${txtrst}"
#  cp "$LOCAL_PEM_DIR/fullchain.pem" "$PROJECT_PEM_DIR"
#  cp "$LOCAL_PEM_DIR/privkey.pem" "$PROJECT_PEM_DIR"
#}

permit_authority_scripts

make_logging_directory

#copy_nginx_pem_files
