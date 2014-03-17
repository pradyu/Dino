//package com.dino.entity;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Document
//@Entity
//@JsonAutoDetect
//public class LocuMenu extends AbstractEntity {
//	@JsonProperty
//	private String menu_name;
//	@JsonProperty
//	private String currency_symbol;
//	@JsonProperty
//	private List<Section> sections;
//
//	protected static class Section {
//		@JsonProperty
//		private String section_name;
//		@JsonProperty
//		private List<SubSection> subsections;
//
//		public String getSection_name() {
//			return section_name;
//		}
//
//		public void setSection_name(String section_name) {
//			this.section_name = section_name;
//		}
//
//		public List<SubSection> getSubsections() {
//			return subsections;
//		}
//
//		public void setSubsections(List<SubSection> subsections) {
//			this.subsections = subsections;
//		}
//
//		@Override
//		public String toString() {
//			StringBuffer sb = new StringBuffer();
//			sb.append("section_name: " + section_name + "\n").toString();
//			for (SubSection subsection : subsections) {
//				sb.append(subsection.toString() + "\n");
//			}
//			return sb.toString();
//		}
//	}
//
//	protected static class SubSection {
//		@JsonProperty
//		private String subsection_name;
//		@JsonProperty
//		private List<SectionTextItem> contents;
//
//		public String getSubsection_name() {
//			return subsection_name;
//		}
//
//		public void setSubsection_name(String subsection_name) {
//			this.subsection_name = subsection_name;
//		}
//
//		public List<SectionTextItem> getContents() {
//			return contents;
//		}
//
//		public void setContents(List<SectionTextItem> contents) {
//			this.contents = contents;
//		}
//
//		@Override
//		public String toString() {
//			StringBuffer sb = new StringBuffer();
//			sb.append("SubSection name: " + subsection_name + "\n");
//			for (SectionTextItem sectionTextItem : contents) {
//				sb.append(sectionTextItem.toString() + "\n");
//			}
//			return sb.toString();
//		}
//	}
//
//	protected static class SectionTextItem {
//		@JsonProperty
//		private String type;
//		@JsonProperty
//		private String text;
//		@JsonProperty
//		private String name;
//		@JsonProperty
//		private String description;
//		@JsonProperty
//		private String price;
//		@JsonProperty
//		private List<OptionGroup> option_groups;
//
//		public String getType() {
//			return type;
//		}
//
//		public void setType(String type) {
//			this.type = type;
//		}
//
//		public String getText() {
//			return text;
//		}
//
//		public void setText(String text) {
//			this.text = text;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//		public String getPrice() {
//			return price;
//		}
//
//		public void setPrice(String price) {
//			this.price = price;
//		}
//
//		public List<OptionGroup> getOption_groups() {
//			return option_groups;
//		}
//
//		public void setOption_groups(List<OptionGroup> option_groups) {
//			this.option_groups = option_groups;
//		}
//		
//		@Override
//		public String toString() {
//			StringBuffer sb = new StringBuffer();
//			sb.append("SectionTextItem type: " + type + "\n")
//			.append("SectionTextItem text: " + text + "\n")
//			.append("SectionTextItem name: " + name + "\n")
//			.append("SectionTextItem description: " + description + "\n")
//			.append("SectionTextItem price: " + price + "\n");
//			if(option_groups != null)
//			for (OptionGroup optiongroup : option_groups) {
//				sb.append(optiongroup.toString() + "\n");
//			}
//			return sb.toString();
//		}
//	}
//
//	protected static class OptionGroup {
//		@JsonProperty
//		private String type;
//		@JsonProperty
//		private String text;
//		@JsonProperty
//		private String description;
//		@JsonProperty
//		private List<Option> options;
//
//		public String getType() {
//			return type;
//		}
//
//		public void setType(String type) {
//			this.type = type;
//		}
//
//		public String getText() {
//			return text;
//		}
//
//		public void setText(String text) {
//			this.text = text;
//		}
//
//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//		public List<Option> getOptions() {
//			return options;
//		}
//
//		public void setOptions(List<Option> options) {
//			this.options = options;
//		}
//
//		@Override
//		public String toString() {
//			StringBuffer sb = new StringBuffer();
//			sb.append("option group type: " + type + "\n")
//			.append("option group text: " + text + "\n")
//			.append("option group description: " + description + "\n");
//			for (Option option : options) {
//				sb.append(option.toString() + "\n");
//			}
//			return sb.toString();
//		}
//	}
//
//	protected static class Option {
//		@JsonProperty
//		private String name;
//		@JsonProperty
//		private String price;
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getPrice() {
//			return price;
//		}
//
//		public void setPrice(String price) {
//			this.price = price;
//		}
//
//		@Override
//		public String toString() {
//			StringBuffer sb = new StringBuffer();
//			return sb.append("option name: " + name + "\n")
//					.append("price: " + price).toString();
//		}
//	}
//
//	public String getMenu_name() {
//		return menu_name;
//	}
//
//	public void setMenu_name(String menu_name) {
//		this.menu_name = menu_name;
//	}
//
//	public String getCurrency_symbol() {
//		return currency_symbol;
//	}
//
//	public void setCurrency_symbol(String currency_symbol) {
//		this.currency_symbol = currency_symbol;
//	}
//
//	public List<Section> getSections() {
//		return sections;
//	}
//
//	public void setSections(List<Section> sections) {
//		this.sections = sections;
//	}
//
//	@Override
//	public String toString() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("id: " + getId() + "\n")
//				.append("menu name: " + getMenu_name() + "\n")
//				.append("currency: " + getCurrency_symbol() + "\n");
//		for (Section section : sections) {
//			sb.append(section.toString() + "\n");
//		}
//		return sb.toString();
//
//	}
//}
