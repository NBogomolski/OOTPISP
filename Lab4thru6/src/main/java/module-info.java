import serialization3.plugin.Base64Plugin;
import serialization3.plugin.BinaryPluginAdapter;
import serialization3.plugin.HexPlugin;
import serialization3.plugin.Plugin;

module plugin {
    requires org.apache.commons.codec;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    exports serialization3.plugin;
    exports serialization3.vehicles;

    uses Plugin;
    provides Plugin with HexPlugin, Base64Plugin, BinaryPluginAdapter;
}