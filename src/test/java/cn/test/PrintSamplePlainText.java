package cn.test;

// Copyright 2020 Sebastian Kuerten
//
// This file is part of odftoolkit-samples.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


import java.io.File;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfPresentationNotes;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.dom.OdfContentDom;
import org.odftoolkit.odfdom.dom.element.presentation.PresentationNotesElement;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.pkg.OdfElement;
import org.odftoolkit.odfdom.pkg.OdfPackage;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Load a file from the resources directory and print its plain text content
 */
@Slf4j
public class PrintSamplePlainText {

    public static void main(String[] args) throws Exception {
        String file = "ppts/demo.odp";
        OdfPresentationDocument odfPresentationDocument = OdfPresentationDocument.loadDocument(new File(file));

        Iterator<OdfSlide> slides = odfPresentationDocument.getSlides();
        while (slides.hasNext()) {
            OdfSlide slide = slides.next();
            String slideName = slide.getSlideName();
            log.debug("slide name is : {}", slideName);

            String slideComment = slide.getNotesPage().getOdfElement().getTextContent();
            log.debug("comment is : {}", slideComment);

            System.out.println(slide.getOdfElement());
        }


    }

}