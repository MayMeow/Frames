/*
 * Copyright (c) 2018. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jahirfiquitiva.libs.frames.helpers.extensions

import android.graphics.BitmapFactory
import jahirfiquitiva.libs.frames.data.models.Dimension
import jahirfiquitiva.libs.frames.data.models.WallpaperInfo

fun ByteArray.toWallpaperInfo(onlySize: Boolean): WallpaperInfo {
    try {
        if (onlySize) return WallpaperInfo(size.toLong(), Dimension(0L, 0L))
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeByteArray(this, 0, size, options)
        val width = options.outWidth
        val height = options.outHeight
        return WallpaperInfo(size.toLong(), Dimension(width.toLong(), height.toLong()))
    } catch (ignored: Exception) {
        return WallpaperInfo(0L, Dimension(0L, 0L))
    }
}