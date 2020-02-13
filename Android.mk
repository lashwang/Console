LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
    $(call all-java-files-under, app/src/main/java/com/gs/console/main) 

LOCAL_MODULE := gs_java_console
LOCAL_JAVA_LIBRARIES := framework conscrypt
include $(BUILD_JAVA_LIBRARY)
