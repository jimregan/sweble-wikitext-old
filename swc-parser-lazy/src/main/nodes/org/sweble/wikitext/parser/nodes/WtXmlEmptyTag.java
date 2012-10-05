package org.sweble.wikitext.parser.nodes;

import org.sweble.wikitext.parser.parser.WtNamedXmlElement;
import org.sweble.wikitext.parser.postprocessor.WtIntermediate;

import de.fau.cs.osr.ptk.common.ast.AstNodePropertyIterator;

/**
 * <h1>Empty XML Element</h1>
 */
public class WtXmlEmptyTag
		extends
			WtInnerNode1
		implements
			WtNamedXmlElement,
			WtIntermediate
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public WtXmlEmptyTag()
	{
		super(new WtNodeList());
	}
	
	public WtXmlEmptyTag(String name, WtNodeList xmlAttributes)
	{
		super(xmlAttributes);
		setName(name);
	}
	
	@Override
	public int getNodeType()
	{
		return org.sweble.wikitext.parser.AstNodeTypes.NT_XML_TAG_EMPTY;
	}
	
	// =========================================================================
	
	@Override
	public boolean isSynthetic()
	{
		return false;
	}
	
	// =========================================================================
	// Properties
	
	private String name;
	
	public final String getName()
	{
		return this.name;
	}
	
	public final String setName(String name)
	{
		String old = this.name;
		this.name = name;
		return old;
	}
	
	@Override
	public final int getPropertyCount()
	{
		return 1 + getSuperPropertyCount();
	}
	
	public final int getSuperPropertyCount()
	{
		return super.getPropertyCount();
	}
	
	@Override
	public final AstNodePropertyIterator propertyIterator()
	{
		return new WtInnerNode1PropertyIterator()
		{
			@Override
			protected int getPropertyCount()
			{
				return WtXmlEmptyTag.this.getPropertyCount();
			}
			
			@Override
			protected String getName(int index)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return "name";
						
					default:
						return super.getName(index);
				}
			}
			
			@Override
			protected Object getValue(int index)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return WtXmlEmptyTag.this.getName();
						
					default:
						return super.getValue(index);
				}
			}
			
			@Override
			protected Object setValue(int index, Object value)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return WtXmlEmptyTag.this.setName((String) value);
						
					default:
						return super.setValue(index, value);
				}
			}
		};
	}
	
	// =========================================================================
	// Children
	
	public final void setXmlAttributes(WtNodeList xmlAttributes)
	{
		set(0, xmlAttributes);
	}
	
	public final WtNodeList getXmlAttributes()
	{
		return (WtNodeList) get(0);
	}
	
	private static final String[] CHILD_NAMES = new String[] { "xmlAttributes" };
	
	public final String[] getChildNames()
	{
		return CHILD_NAMES;
	}
}