1) Änderungshistorie:
=====================

Version 2.0 (5.11.2013)
-------------------------
* Beispiele für neue Druckauflage JavaServer Faces 2.2.


Version 1.3 (1.7.2013)
-------------------------
* Die Abhängigkeiten auf Apache MyFaces in MyGourmet wurden von Version 2.1.8
  auf Version 2.1.12 umgestellt.

* Die Abhängigkeiten auf Mojarra in MyGourmet wurden von Version 2.1.11 auf
  Version 2.1.23 umgestellt.


Version 1.2 (27.2.2013)
-------------------------
* In den Ajax-Beispielen ist bei h:selectBooleanCheckbox zum Ein- und Ausblenden
  der Kreditkartendaten immediate wieder auf true gesetzt um eine Validierung der
  Daten zu vermeiden.

* Die Beispiele MyGourmet 15, MyGourmet 16 und MyGourmet Fullstack gibt es
  jetzt auch in einer CDI-Variante.

* Mit MyGourmet 17 und MyGourmet Fullstack PrimeFaces gibt es zwei neue
  Beispiele die PrimeFaces 3.5 benutzen.

* Im Beispiel MyGourmet Fullstack (Spring und CDI) wird verstärkt
  GET-Navigation im Provider-Bereich benutzt.

Version 1.1 (16.9.2012)
-------------------------
* In der Kompositkomponente mc:inputSpinner wurde ein Konverter zu h:inputText
  hinzugefügt, um ein Fehlverhalten von JSF 2.0 und 2.1 zu umgehen.

* Minimale Änderungen am Code um Java 7-Kompatibilität zu gewährleisten.

* In den Beispielen MyGourmet 13 bis MyGourmet 16 wurde die Managed-Bean
  ProviderListBean eingeführt.

* Die Abhängigkeiten auf Apache MyFaces in MyGourmet wurden von Version 2.1.0
  auf Version 2.1.8 umgestellt.

* Die Abhängigkeiten auf Mojarra in MyGourmet wurden von Version 2.0.1 auf
  Version 2.1.11 umgestellt.

* In allen MyGourmet-Beispielen wurde das Jetty-Maven-Plug-in auf Version
  8.1.5.v20120716 (Servlet 3.0) umgestellt.

* Durch die Umstellung auf das Jetty-Maven-Plug-in 8 konnte die Servlet-Version
  in der web.xml auf 3.0 geändert werden. Weiters ist dadurch die JBoss-EL
  nicht mehr notwendig und wurde entfernt.

* In allen MyGourmet-Beispielen wurde das Maven-Eclipse-Plug-in auf Version 2.9
  umgestellt und um einige Einstellungen erweitert.

Version 1.0.5 (15.9.2011)
-------------------------
* Die Abhängigkeiten auf Apache MyFaces in MyGourmet wurden von Version 2.0.4
  auf Version 2.1.0 umgestellt.

Version 1.0.4 (8.4.2011)
------------------------
* Von Beispiel MyGourmet 13 wurde eine zweite Version hinzugefügt, bei der alle
  Komponenten, Konverter und Validatoren in einer einfachen Komponentenbibliothek
  zusammengefasst sind.

* Bei alle MyGourmet-Beispielen ist die Project-Stage jetzt auf Development
  gesetzt.

* Die Abhängigkeiten auf Apache MyFaces in MyGourmet wurden von Version 2.0.0
  auf Version 2.0.4 umgestellt.

* In allen MyGourmet-Beispielen wurde das Jetty-Maven-Plug-in auf Version
  7.2.2.v20101205 umgestellt. Damit lassen sich die Beispiele jetzt ohne
  Probleme mit mvn jetty:run starten.

* Die Abhängigkeiten auf Hibernate Validator in MyGourmet wurden wegen Problemen
  mit lokalisierten Nachrichten von Version 4.0.2.GA auf Version 4.1.0.Final
  umgestellt.

Version 1.0.3 (22.12.2010)
--------------------------
* In den Beispielen MyGourmet 13 - MyGourmet 16 und MyGourmet Fullstack wurde die
  Kompositkomponente collapsiblePanel mit einer eigenen Wurzelkomponente ausgestattet.

* In den Beispielen MyGourmet 13 - MyGourmet 16 und MyGourmet Fullstack war in der
  Kompositkomponente inputSpinner die nicht existierende CSS-Ressource
  inputSpinner.css eingebunden. Der richtige Name lautet components.css.

* Der Präfix für den Namensraum http://java.sun.com/jsf/composite/ wurde generell
  von composite auf cc geändert.

Version 1.0.2 (28.6.2010)
-------------------------
* Die Abhängigkeiten auf Apache MyFaces in MyGourmet wurden von der Betaversion
  2.0.0-beta-2 auf die stabile Version 2.0.0 umgestellt.
  
* Alle MyGourmet-Beispiele benutzen jetzt standardmäßig Apache MyFaces als
  JSF-Implementierung.

* Beim Ein- und Ausblenden der Kreditkartendaten hat sich in den Ajax-Beispielen
  (MyGourmet 14 - MyGourmet 16 und MyGourmet Fullstack) ein Fehler eingeschlichen.
  Fälschlicherweise wurde in diesem Fall nur das Auswahlfeld, nicht aber die
  Werte der beiden Eingabefelder an den Server geschickt. Dadurch gingen alle
  Änderungen der Kreditkartendaten beim Ausblenden der Felder verloren.
  
* In MyGourmet Fullstack wurde in der Seitendeklaration /editDish.xhtml das Tag
  f:convertNumber für den Preis entfernt, da ganzahlige Werte damit in Werte vom
  Typ Long umgewandelt werden.
    
* Der Phase-Listener ParameterPhaseListener gibt die Parameter jetzt vor der
  Apply-Request-Values-Phase aus, um Probleme mit Umlauten zu vermeiden.
  
* Die Beispiel MyGourmet 15, MyGourmet 16 und MyGourmet Fullstack wurden
  komplett auf Spring in Version 3.0 in Kombination mit JSR-330-Annotationen
  umgestellt.
  
* Das Beispiel MyGourmet Tobago wurde von JSF 1.1 auf JSF 1.2 umgestellt
  (MyFaces 1.2.8 und Mojarra 1.2_14). Zusätzlich wurde die Version von Tobago
  auf 1.0.25 und die Version von Orchestra auf 1.4 aktualisiert. Außerdem gibt
  es jetzt die Möglichkeit Mojarra in der pom.xml über das Profil mit der
  ID mojarra zu verwenden.
  
* Die Funktionalität von MyGourmet Tobago wurde erweitert und weiter an
  MyGourmet Fullstack angeglichen.

Version 1.0.1 (3.2.2010)
------------------------
* Alle Beispiele laufen jetzt auch mit der Version 2.0.0-beta von Apache MyFaces.
  Dazu muss das in der pom.xml definierte Profil myfaces aktiviert werden.

* Die Abhängigkeit auf Apache MyFaces Orchestra wurde auf myfaces-orchestra-core20
  in Version 1.4 umgestellt. Das Artefakt mit der ID myfaces-orchestra-core15 ist
  darin bereits enthalten und wurde aus der Datei pom.xml entfernt. Die an JSF 2.0
  angepassten Orchestra-Klassen in MyGourmet Fullstack werden daher nicht mehr
  benötigt.

* Die EL-Implementierung wurde ab Beispiel MyGourmet 9 auf JBoss-EL umgestellt.

* Alle Konverter und Validatoren in MyGourmet implementieren jetzt Serializable
  und haben eine serialVersionUID.

* Die Validierungsmethode validateCreditNumber der Klasse CustomerBean
  beziehungsweise CustomerBeanBase ab MyGourmet 16 funktioniert jetzt für den
  Wert null.

* Die Validierungsgruppe und die f:validateBean-Tags der Kreditkartenfelder
  wurden entfernt, da sie für unsere Beispiele nicht benötigt werden.

* Im Konverter ListConverter wurde die Eigenschaft bundle vom Typ ResourceBundle
  mit der Eigenschaft bundleName vom Typ String ersetzt. Der Konverter bekommt
  jetzt nur mehr den Namen des Bundles da die Klasse ResourceBundle nicht
  serialisierbar ist.

* In MyGourmet Fullstack gab es ein Problem beim Löschen von Anbietern, für die
  es bereits Bestellungen gibt.

Version 1.0 (20.11.2009)
------------------------
* Die Abhängigkeiten auf Mojarra in MyGourmet wurden von der
  Entwicklungsversion 2.0.0-SNAPSHOT auf die stabile Version 2.0.1 umgestellt.

* Die Abhängigkeit auf die Bean Validation API in MyGourmet wurden von der
  Entwicklungsversion 1.0.CR2 auf die stabile Version 1.0.0.GA umgestellt.

* Die Abhängigkeit auf Hibernate Validator in MyGourmet wurden von der
  Entwicklungsversion 4.0.0.Beta1 auf die stabile Version 4.0.2.GA umgestellt.

* Im Zuge der Umstellung der Bean Validation API auf die stabile Version
  1.0.0.GA gab es einige kleinere Änderungen, die im Code von MyGourmet
  berücksichtigt wurden.
