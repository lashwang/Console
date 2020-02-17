LOCAL_PATH := $(my-dir)

include $(CLEAR_VARS)

local_target_dir := $(TARGET_OUT_ETC)/console_assets

LOCAL_MODULE := cacrt.crt
LOCAL_MODULE_CLASS := ETC
LOCAL_MODULE_PATH := $(local_target_dir)
LOCAL_SRC_FILES := $(LOCAL_MODULE)
include $(BUILD_PREBUILT)

