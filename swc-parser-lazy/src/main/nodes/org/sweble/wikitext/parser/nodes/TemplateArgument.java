package org.sweble.wikitext.parser.nodes;

import de.fau.cs.osr.ptk.common.ast.AstNodePropertyIterator;

/**
 * <h1>TemplateArgument</h1> <h2>Grammar</h2>
 */
public class TemplateArgument
		extends
			WtInnerNode2
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public TemplateArgument()
	{
		super(new WtList(), new WtList());
		
	}
	
	public TemplateArgument(WtList value, boolean hasName)
	{
		super(new WtList(), value);
		setHasName(hasName);
		
	}
	
	public TemplateArgument(WtList name, WtList value, boolean hasName)
	{
		super(name, value);
		setHasName(hasName);
		
	}
	
	@Override
	public int getNodeType()
	{
		return org.sweble.wikitext.parser.AstNodeTypes.NT_TEMPLATE_ARGUMENT;
	}
	
	// =========================================================================
	// Properties
	
	private boolean hasName;
	
	public final boolean getHasName()
	{
		return this.hasName;
	}
	
	public final boolean setHasName(boolean hasName)
	{
		boolean old = this.hasName;
		this.hasName = hasName;
		return old;
	}
	
	@Override
	public final int getPropertyCount()
	{
		return 1 + getSuperPropertyCount();
	}
	
	public int getSuperPropertyCount()
	{
		return super.getPropertyCount();
	}
	
	@Override
	public final AstNodePropertyIterator propertyIterator()
	{
		return new WtInnerNode2PropertyIterator()
		{
			@Override
			protected int getPropertyCount()
			{
				return TemplateArgument.this.getPropertyCount();
			}
			
			@Override
			protected String getName(int index)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return "hasName";
						
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
						return TemplateArgument.this.getHasName();
						
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
						return TemplateArgument.this.setHasName((Boolean) value);
						
					default:
						return super.setValue(index, value);
				}
			}
		};
	}
	
	// =========================================================================
	// Children
	
	public final void setName(WtList name)
	{
		set(0, name);
	}
	
	public final WtList getName()
	{
		return (WtList) get(0);
	}
	
	public final void setValue(WtList value)
	{
		set(1, value);
	}
	
	public final WtList getValue()
	{
		return (WtList) get(1);
	}
	
	private static final String[] CHILD_NAMES = new String[] { "name", "value" };
	
	public final String[] getChildNames()
	{
		return CHILD_NAMES;
	}
}
