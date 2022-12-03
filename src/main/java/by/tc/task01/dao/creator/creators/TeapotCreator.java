package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Teapot;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents creator of a speakers appliance
 */
public class TeapotCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "powerConsumption";
    private static final String HEIGHT = "Height";
    private static final String WIDTH = "Width";
    private static final String CORD_LENGTH = "cordLength";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(NodeList nodes) {
        Teapot Teapot = new Teapot();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case POWER_CONSUMPTION -> Teapot.powerConsumption = Integer.parseInt(text);
                    case HEIGHT -> Teapot.Height = Integer.parseInt(text);
                    case WIDTH -> Teapot.Width = Integer.parseInt(text);
                    case CORD_LENGTH -> Teapot.cordLength = Integer.parseInt(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }
        return Teapot;
    }
}
