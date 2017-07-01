package com.wsbook.xmlxsl.sample;

import java.io.InputStream;

public class ClassPathURIResolver implements javax.xml.transform.URIResolver {

	/**
	 * ClassPathURIResolver constructor comment.
	 */
	public ClassPathURIResolver() {
		super();
	}
	/**
	 * Called by the processor when it encounters
	 * an xsl:include, xsl:import, or document() function.
	 *
	 * @param href An href attribute, which may be relative or absolute.
	 * @param base The base URI in effect when the href attribute
	 * was encountered.
	 *
	 * @return A Source object, or null if the href cannot be resolved,
	 * and the processor should try to resolve the URI itself.
	 *
	 * @throws TransformerException if an error occurs when trying to
	 * resolve the URI.
	 */
	public javax.xml.transform.Source resolve(String href, String base) throws javax.xml.transform.TransformerException {

		javax.xml.transform.stream.StreamSource result = null;

		String path = href;
		try {

			InputStream inputStream = getClass().getResourceAsStream(path);
			System.out.println("ClassPathURIResolver.resolve() path = " + path);
			if (inputStream != null) {
				result = new javax.xml.transform.stream.StreamSource();
				result.setInputStream(inputStream);
			}
		} catch (Exception exc) {
			System.out.println(
				"ClassPathURIResolver.resolve() Exception occurred on --> href = "
					+ href
					+ " base = "
					+ base
					+ " Exception = "
					+ exc);
		}

		System.out.println(
			"ClassPathURIResolver.resolve() resolved path = " + path + " href = " + href + " base = " + base );
		return result;
	}
}
