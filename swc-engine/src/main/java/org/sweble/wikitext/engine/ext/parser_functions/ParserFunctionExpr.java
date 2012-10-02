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

package org.sweble.wikitext.engine.ext.parser_functions;

import static org.sweble.wikitext.parser.utils.AstBuilder.astText;

import java.util.List;

import org.sweble.wikitext.engine.ExpansionFrame;
import org.sweble.wikitext.engine.SoftErrorNode;
import org.sweble.wikitext.engine.ext.parser_functions.ExprParser.ExprError;
import org.sweble.wikitext.parser.nodes.Template;
import org.sweble.wikitext.parser.nodes.WikitextNode;
import org.sweble.wikitext.parser.utils.StringConversionException;
import org.sweble.wikitext.parser.utils.StringConverter;

public class ParserFunctionExpr
		extends
			ParserFunctionsExtPfn
{
	private static final long serialVersionUID = 1L;
	
	public ParserFunctionExpr()
	{
		super("expr");
	}
	
	@Override
	public WikitextNode invoke(
			Template pfn,
			ExpansionFrame frame,
			List<? extends WikitextNode> args)
	{
		if (args.size() < 1)
			return astText("");
		
		WikitextNode arg0 = frame.expand(args.get(0));
		
		String expr = null;
		try
		{
			expr = StringConverter.convert(arg0).trim();
		}
		catch (StringConversionException e)
		{
			return new SoftErrorNode(pfn);
		}
		
		ExprParser p = new ExprParser();
		try
		{
			return astText(p.parse(expr));
		}
		catch (ExprError e)
		{
			return new SoftErrorNode(e.getMessage());
		}
	}
}