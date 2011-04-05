/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.mtp;

/**
 * This class represents a storage unit on an MTP device.
 * Used only for MTP support in USB responder mode.
 * MtpStorageInfo is used in MTP host mode
 *
 * @hide
 */
public class MtpStorage {

    private final int mStorageId;
    private final String mPath;
    private final String mDescription;
    private final long mReserveSpace;

    public MtpStorage(int id, String path, String description, long reserveSpace) {
        mStorageId = id;
        mPath = path;
        mDescription = description;
        mReserveSpace = reserveSpace;
    }

    /**
     * Returns the storage ID for the storage unit
     *
     * @return the storage ID
     */
    public final int getStorageId() {
        return mStorageId;
    }

    /**
     * Generates a storage ID for storage of given index.
     * Index 0 is for primary external storage
     *
     * @return the storage ID
     */
    public static int getStorageId(int index) {
        // storage ID is 0x00010001 for primary storage,
        // then 0x00020001, 0x00030001, etc. for secondary storages
        return ((index + 1) << 16) + 1;
    }

   /**
     * Returns the file path for the storage unit's storage in the file system
     *
     * @return the storage file path
     */
    public final String getPath() {
        return mPath;
    }

   /**
     * Returns the description string for the storage unit
     *
     * @return the storage unit description
     */
    public final String getDescription() {
        return mDescription;
    }

   /**
     * Returns the amount of space to reserve on the storage file system.
     * This can be set to a non-zero value to prevent MTP from filling up the entire storage.
     *
     * @return the storage unit description
     */
    public final long getReserveSpace() {
        return mReserveSpace;
    }

}
