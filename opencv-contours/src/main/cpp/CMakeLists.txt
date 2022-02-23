
#
# Copyright (C) The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

cmake_minimum_required(VERSION 3.4.1)

# configure import libs
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../distribution)

add_library(lib_opencv_core STATIC IMPORTED)
set_target_properties(lib_opencv_core PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/core/lib/${ANDROID_ABI}/libopencv_core.a)

# ${ANDROID_ABI} is handy for our purpose here. Probably this ${ANDROID_ABI} is
# the most valuable thing of this sample, the rest are pretty much normal cmake

add_library(lib_opencv_imgproc STATIC IMPORTED)
set_target_properties(lib_opencv_imgproc PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/imgproc/lib/${ANDROID_ABI}/libopencv_imgproc.a)

add_library(lib_opencv_imgcodecs STATIC IMPORTED)
set_target_properties(lib_opencv_imgcodecs PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/imgcodecs/lib/${ANDROID_ABI}/libopencv_imgcodecs.a)

# build application's shared lib
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

add_library(opencv-static-libs SHARED
        static-libs.cpp)

target_include_directories(opencv-static-libs PRIVATE
                            ${distribution_DIR}/include)

target_link_libraries(opencv-static-libs
                      android
                      lib_opencv_core
        lib_opencv_imgcodecs
        lib_opencv_imgproc
                      log)
