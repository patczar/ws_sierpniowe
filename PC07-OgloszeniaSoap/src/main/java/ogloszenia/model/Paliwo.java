package ogloszenia.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Paliwo {
	@XmlEnumValue("benzyna") PB,
	@XmlEnumValue("olej") ON,
	@XmlEnumValue("gaz") LPG,
}
