/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sweble.wikitext.engine.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class MagicWord
		implements
			Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Boolean caseSensitive;
	
	private TreeSet<String> aliases;
	
	// =========================================================================
	
	public MagicWord(
			String name,
			Boolean caseSensitive,
			Collection<String> aliases)
	{
		this.name = name;
		this.caseSensitive = caseSensitive;
		this.aliases = new TreeSet<String>(
				new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						return MagicWord.this.caseSensitive ? 
								o1.compareTo(o2) : 
								o1.compareToIgnoreCase(o2);
					}
				});
		
		this.aliases.addAll(aliases);
	}
	
	// =========================================================================
	
	public String getName()
	{
		return name;
	}
	
	public Boolean isCaseSensitive()
	{
		return caseSensitive;
	}
	
	public TreeSet<String> getAliases()
	{
		return aliases;
	}
	
	public boolean hasAlias(String alias)
	{
		return aliases.contains(alias);
	}
}
