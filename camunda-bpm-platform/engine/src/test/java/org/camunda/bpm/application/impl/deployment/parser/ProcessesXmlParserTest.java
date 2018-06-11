package org.camunda.bpm.application.impl.deployment.parser;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.application.impl.metadata.ProcessesXmlParser;
import org.camunda.bpm.application.impl.metadata.spi.ProcessArchiveXml;
import org.camunda.bpm.application.impl.metadata.spi.ProcessesXml;
import org.camunda.bpm.container.impl.metadata.spi.ProcessEngineXml;
import org.camunda.bpm.engine.ProcessEngineException;

import junit.framework.TestCase;

/**
 * <p>The testcases for the {@link ProcessesXmlParser}</p>
 *
 * @author Daniel Meyer
 *
 */
public class ProcessesXmlParserTest extends TestCase {

  private ProcessesXmlParser parser;

  @Override
  protected void setUp() throws Exception {
    parser = new ProcessesXmlParser();
    super.setUp();
  }

  protected URL getStreamUrl(String filename) {
    return ProcessesXmlParserTest.class.getResource(filename);
  }

  public void testParseProcessesXmlOneEngine() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_one_engine.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(1, processesXml.getProcessEngines().size());
    assertEquals(0, processesXml.getProcessArchives().size());

    ProcessEngineXml engineXml = processesXml.getProcessEngines().get(0);
    assertEquals("default", engineXml.getName());
    assertEquals("default", engineXml.getJobAcquisitionName());
    assertEquals("configuration", engineXml.getConfigurationClass());
    assertEquals("datasource", engineXml.getDatasource());

    Map<String, String> properties = engineXml.getProperties();
    assertNotNull(properties);
    assertEquals(2, properties.size());

    assertEquals("value1", properties.get("prop1"));
    assertEquals("value2", properties.get("prop2"));

  }

  public void testParseProcessesXmlTwoEngines() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_two_engines.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(2, processesXml.getProcessEngines().size());
    assertEquals(0, processesXml.getProcessArchives().size());

    ProcessEngineXml engineXml1 = processesXml.getProcessEngines().get(0);
    assertEquals("engine1", engineXml1.getName());
    assertEquals("configuration", engineXml1.getConfigurationClass());
    assertEquals("datasource", engineXml1.getDatasource());

    Map<String, String> properties1 = engineXml1.getProperties();
    assertNotNull(properties1);
    assertEquals(2, properties1.size());

    assertEquals("value1", properties1.get("prop1"));
    assertEquals("value2", properties1.get("prop2"));

    ProcessEngineXml engineXml2 = processesXml.getProcessEngines().get(1);
    assertEquals("engine2", engineXml2.getName());
    assertEquals("configuration", engineXml2.getConfigurationClass());
    assertEquals("datasource", engineXml2.getDatasource());

    // the second engine has no properties
    Map<String, String> properties2 = engineXml2.getProperties();
    assertNotNull(properties2);
    assertEquals(0, properties2.size());

  }

  public void testParseProcessesXmlOneArchive() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_one_archive.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(0, processesXml.getProcessEngines().size());
    assertEquals(1, processesXml.getProcessArchives().size());

    ProcessArchiveXml archiveXml1 = processesXml.getProcessArchives().get(0);
    assertEquals("pa1", archiveXml1.getName());
    assertEquals("default", archiveXml1.getProcessEngineName());

    List<String> resourceNames = archiveXml1.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames.get(0));
    assertEquals("process2.bpmn", resourceNames.get(1));

    Map<String, String> properties1 = archiveXml1.getProperties();
    assertNotNull(properties1);
    assertEquals(2, properties1.size());

    assertEquals("value1", properties1.get("prop1"));
    assertEquals("value2", properties1.get("prop2"));

  }

  public void testParseProcessesXmlTwoArchives() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_two_archives.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(0, processesXml.getProcessEngines().size());
    assertEquals(2, processesXml.getProcessArchives().size());


    ProcessArchiveXml archiveXml1 = processesXml.getProcessArchives().get(0);
    assertEquals("pa1", archiveXml1.getName());
    assertEquals("default", archiveXml1.getProcessEngineName());

    List<String> resourceNames = archiveXml1.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames.get(0));
    assertEquals("process2.bpmn", resourceNames.get(1));

    Map<String, String> properties1 = archiveXml1.getProperties();
    assertNotNull(properties1);
    assertEquals(2, properties1.size());

    assertEquals("value1", properties1.get("prop1"));
    assertEquals("value2", properties1.get("prop2"));

    ProcessArchiveXml archiveXml2 = processesXml.getProcessArchives().get(1);
    assertEquals("pa2", archiveXml2.getName());
    assertEquals("default", archiveXml2.getProcessEngineName());

    List<String> resourceNames2 = archiveXml2.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames2.get(0));
    assertEquals("process2.bpmn", resourceNames2.get(1));

    Map<String, String> properties2 = archiveXml2.getProperties();
    assertNotNull(properties2);
    assertEquals(0, properties2.size());

  }

  public void testParseProcessesXmlTwoArchivesAndTwoEngines() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_two_archives_two_engines.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(2, processesXml.getProcessEngines().size());
    assertEquals(2, processesXml.getProcessArchives().size());

    // validate archives

    ProcessArchiveXml archiveXml1 = processesXml.getProcessArchives().get(0);
    assertEquals("pa1", archiveXml1.getName());
    assertEquals("default", archiveXml1.getProcessEngineName());

    List<String> resourceNames = archiveXml1.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames.get(0));
    assertEquals("process2.bpmn", resourceNames.get(1));

    Map<String, String> properties1 = archiveXml1.getProperties();
    assertNotNull(properties1);
    assertEquals(2, properties1.size());

    assertEquals("value1", properties1.get("prop1"));
    assertEquals("value2", properties1.get("prop2"));

    ProcessArchiveXml archiveXml2 = processesXml.getProcessArchives().get(1);
    assertEquals("pa2", archiveXml2.getName());
    assertEquals("default", archiveXml2.getProcessEngineName());

    List<String> resourceNames2 = archiveXml2.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames2.get(0));
    assertEquals("process2.bpmn", resourceNames2.get(1));

    Map<String, String> properties2 = archiveXml2.getProperties();
    assertNotNull(properties2);
    assertEquals(0, properties2.size());

    // validate engines

    ProcessEngineXml engineXml1 = processesXml.getProcessEngines().get(0);
    assertEquals("engine1", engineXml1.getName());
    assertEquals("configuration", engineXml1.getConfigurationClass());
    assertEquals("datasource", engineXml1.getDatasource());

    properties1 = engineXml1.getProperties();
    assertNotNull(properties1);
    assertEquals(2, properties1.size());

    assertEquals("value1", properties1.get("prop1"));
    assertEquals("value2", properties1.get("prop2"));

    ProcessEngineXml engineXml2 = processesXml.getProcessEngines().get(1);
    assertEquals("engine2", engineXml2.getName());
    assertEquals("configuration", engineXml2.getConfigurationClass());
    assertEquals("datasource", engineXml2.getDatasource());

    // the second engine has no properties
    properties2 = engineXml2.getProperties();
    assertNotNull(properties2);
    assertEquals(0, properties2.size());

  }

  public void testParseProcessesXmlEngineNoName() {

    // this test is to make sure that XML Schema Validation works.
    try {
      parser.createParse()
        .sourceUrl(getStreamUrl("process_xml_engine_no_name.xml"))
        .execute();

      fail("exception expected");

    } catch(ProcessEngineException e) {
      // expected
    }

  }

  public void FAILING_testParseProcessesXmlClassLineBreak() {

    ProcessesXml processesXml = parser.createParse()
        .sourceUrl(getStreamUrl("process_xml_one_archive_with_line_break.xml"))
        .execute()
        .getProcessesXml();

    assertNotNull(processesXml);

    ProcessArchiveXml archiveXml1 = processesXml.getProcessArchives().get(0);
    List<String> resourceNames = archiveXml1.getProcessResourceNames();
    assertEquals(2, resourceNames.size());
    assertEquals("process1.bpmn", resourceNames.get(0));

  }

  public void testParseProcessesXmlNsPrefix() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_ns_prefix.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);

    assertEquals(1, processesXml.getProcessEngines().size());
    assertEquals(1, processesXml.getProcessArchives().size());

  }

  public void testParseProcessesXmlTenantId() {

    ProcessesXml processesXml = parser.createParse()
      .sourceUrl(getStreamUrl("process_xml_tenant_id.xml"))
      .execute()
      .getProcessesXml();

    assertNotNull(processesXml);
    assertEquals(2, processesXml.getProcessArchives().size());

    ProcessArchiveXml archiveXmlWithoutTenantId = processesXml.getProcessArchives().get(0);
    assertNull(archiveXmlWithoutTenantId.getTenantId());

    ProcessArchiveXml archiveXmlWithTenantId = processesXml.getProcessArchives().get(1);
    assertEquals("tenant1", archiveXmlWithTenantId.getTenantId());
  }

}
