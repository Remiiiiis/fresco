/*
 * Copyright (c) 2015-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageLoadStatus;
import com.facebook.drawee.backends.pipeline.info.ImageOrigin;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

public class ImagePerfImageOriginListener implements ImageOriginListener {

  private final ImagePerfState mImagePerfState;
  private final ImagePerfMonitor mImagePerfMonitor;

  public ImagePerfImageOriginListener(
      ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
    mImagePerfState = imagePerfState;
    mImagePerfMonitor = imagePerfMonitor;
  }

  @Override
  public void onImageLoaded(String controllerId, @ImageOrigin int imageOrigin, boolean successful) {
    mImagePerfState.setImageOrigin(imageOrigin);
    mImagePerfMonitor.notifyStatusUpdated(mImagePerfState, ImageLoadStatus.ORIGIN_AVAILABLE);
  }
}