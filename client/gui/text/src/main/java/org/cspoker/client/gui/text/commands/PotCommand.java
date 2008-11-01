/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.client.gui.text.commands;

import org.cspoker.client.gui.text.Console;
import org.cspoker.client.gui.text.savedstate.Pot;

public class PotCommand implements Command {

	private Pot pot;
	private Console console;

	public PotCommand(Console console, Pot pot) {
		this.pot = pot;
		this.console = console;
	}

	public void execute(String... args) throws Exception {
		console.print("The total pot is " + pot.getPot() + " chips.");
	}

}