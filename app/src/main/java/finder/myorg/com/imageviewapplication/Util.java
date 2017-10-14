package finder.myorg.com.imageviewapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import finder.myorg.com.imageviewapplication.model.Product;
import finder.myorg.com.imageviewapplication.model.ProductSKUImage;
import finder.myorg.com.imageviewapplication.model.Products;
import finder.myorg.com.imageviewapplication.model.Sku;
import finder.myorg.com.imageviewapplication.model.SkuImageAttribute;
import finder.myorg.com.imageviewapplication.model.SkuImages;

public class Util {

	/*public static void main(String[] args) {

		final String MAIN_PROD_IMAGE = "mainProductImage";
		final String ZOOM_PROD_IMAGE = "zoomProductImage";

		try {
			String sUrl = "https://apiservices.myorg.com/v1/products?productcode=8101440801096&format=json&apikey=4gGFoVurxEnMll0iDiAZSlViOxL1QKF3&options=skus";
			Gson gson = new Gson();
			Products products = gson.fromJson(IOUtils.toString(new URL(sUrl)),
					Products.class);
			if (null != products) {
				int iProducts = products.getProducts().size();
				for (int i = 0; i < iProducts; i++) {
					Product product = products.getProducts().get(i);
					if (null != product) {
						List<Sku> lSKus = product.getSkus();
						if (null != lSKus && !lSKus.isEmpty()) {
							for (int skus = 0; skus < lSKus.size(); skus++) {
								if (null != lSKus.get(skus)) {
									SkuImages skuImages = lSKus.get(skus)
											.getSkuImages();
									if (null != skuImages) {
										List<ProductSKUImage> lprodSkuImg = skuImages
												.getProductSKUImages();
										if (null != lprodSkuImg
												&& !lprodSkuImg.isEmpty()) {
											for (int prodImages = 0; prodImages < lprodSkuImg
													.size(); prodImages++) {
												ProductSKUImage prodSkuImg = lprodSkuImg
														.get(prodImages);
												if (null != prodSkuImg) {
													List<SkuImageAttribute> lskuImgAttrs = prodSkuImg
															.getSkuImageAttribute();

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(products.getProducts().get(0).getSkus().get(0)
					.getSkuImages().getProductSKUImages().get(0)
					.getSkuImageAttribute().get(0).getValue());

		} catch (JsonSyntaxException e) {
			System.out.println("JsonEx " + e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println("MalFormE " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOE " + e.getMessage());
		}

	}*/

	public static List<SkuImageAttribute> getSkuImageAttributes() {

		List<SkuImageAttribute> listSKuImageAttrs = null;
		try {
			listSKuImageAttrs = new ArrayList<SkuImageAttribute>();
			//String sUrl = "https://apiservices.myorg.com/v1/products?productcode=8101440801096&format=json&apikey=4gGFoVurxEnMll0iDiAZSlViOxL1QKF3&options=skus";
			String sUrl = "https://apiservices.myorg.com/v1/products?productcode=999999911697HOME&format=json&apikey=4gGFoVurxEnMll0iDiAZSlViOxL1QKF3&options=skus";
			Gson gson = new Gson();
			Products products = gson.fromJson(IOUtils.toString(new URL(sUrl)),
					Products.class);
			if (null != products) {
				int iProducts = products.getProducts().size();
				for (int i = 0; i < iProducts; i++) {
					Product product = products.getProducts().get(i);
					if (null != product) {
						List<Sku> lSKus = product.getSkus();
						if (null != lSKus && !lSKus.isEmpty()) {
							for (int skus = 0; skus < lSKus.size(); skus++) {
								if (null != lSKus.get(skus)) {
									SkuImages skuImages = lSKus.get(skus)
											.getSkuImages();
									if (null != skuImages) {
										List<ProductSKUImage> lprodSkuImg = skuImages
												.getProductSKUImages();
										if (null != lprodSkuImg
												&& !lprodSkuImg.isEmpty()) {
											for (int prodImages = 0; prodImages < lprodSkuImg
													.size(); prodImages++) {
												ProductSKUImage prodSkuImg = lprodSkuImg
														.get(prodImages);
												if (null != prodSkuImg) {
													/*List<SkuImageAttribute> lskuImgAttrs = prodSkuImg
															.getSkuImageAttribute();*/
													listSKuImageAttrs.addAll(prodSkuImg
															.getSkuImageAttribute());

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (JsonSyntaxException e) {
			System.out.println("JsonEx " + e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println("MalFormE " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOE " + e.getMessage());
		}
		return listSKuImageAttrs; 	
	}

	public static List getListOfBitmaps(List<SkuImageAttribute> lskuImgAttrs) {
		//This method should return the Map of List of Main Image(Bitmap) and ZoomImage Url.
		final String MAIN_PROD_IMAGE = "mainProductImage";
		final String ZOOM_PROD_IMAGE = "zoomProductImage";
		List<Bitmap> lGalleryInfo = new ArrayList();;
		for (int images = 0; images < lskuImgAttrs.size(); images++) {
			SkuImageAttribute skuImgAttr = lskuImgAttrs.get(images);
			if (null != skuImgAttr) {
				if(null != skuImgAttr.getValue()) {
					Bitmap bitmap = getBitMapfromURL(skuImgAttr.getValue());
					if(null != bitmap)
                    lGalleryInfo.add(bitmap);
				}
			}
		}
		return lGalleryInfo;
	}

	public static Bitmap getBitMapfromURL(String sUrl) {


		Bitmap image = null;
		try {
			URL imageURL = new URL(sUrl);
			image = BitmapFactory.decodeStream(imageURL.openConnection()
					.getInputStream());
		} catch (MalformedURLException e) {
			System.out.println("URL Malformed " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException:  " + e.getMessage());
		}
		return image;

		/*try {
			URL imageURL = new URL(sUrl);
			BufferedImage originalImage = ImageIO.read(imageURL);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);

			String outputImageName = new Date().getSeconds()+".bmp";
			FileOutputStream fos = new FileOutputStream(outputImageName);
			baos.writeTo(fos);
			fos.close();
			Thread.sleep(2000);
		} catch (MalformedURLException e) {
			System.out.println("Malformed "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException:  "+e.getMessage());
		}catch(InterruptedException ie){
			System.out.println("InterruptedException "+ie.getMessage());

		}*/

	}
	
	/*public static void main(String[] args) {
		Util parseSkus = new Util();
		List<SkuImageAttribute> lSkuImgAttrs = parseSkus.getSkuImageAttributes();
		parseSkus.getListOfBitmaps(lSkuImgAttrs);
	}*/

	public static List<String> getListOfURLs(List<SkuImageAttribute> lskuImgAttrs) {
		List<String> listUrls = new ArrayList<String>();
		for (int images = 0; images < lskuImgAttrs.size(); images++) {
			SkuImageAttribute skuImgAttr = lskuImgAttrs.get(images);
			if (null != skuImgAttr) {
				if(null != skuImgAttr.getValue()) {
					listUrls.add(skuImgAttr.getValue());
				}
			}
		}
        return listUrls;
	}

}
