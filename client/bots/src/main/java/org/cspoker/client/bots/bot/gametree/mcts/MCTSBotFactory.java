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
package org.cspoker.client.bots.bot.gametree.mcts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import org.cspoker.client.bots.bot.Bot;
import org.cspoker.client.bots.bot.BotFactory;
import org.cspoker.client.bots.bot.gametree.mcts.listeners.MCTSListener;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.SampleProportionateSelector;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.SamplingToFunctionSelector;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.SelectionStrategy;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.UCTSelector;
import org.cspoker.client.bots.bot.gametree.opponentmodel.OpponentModel;
import org.cspoker.client.bots.bot.gametree.opponentmodel.weka.WekaRegressionModel;
import org.cspoker.client.bots.listener.BotListener;
import org.cspoker.client.common.SmartLobbyContext;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.table.TableId;
import org.cspoker.common.handeval.spears2p2.StateTableEvaluator;

import weka.classifiers.Classifier;

public class MCTSBotFactory implements BotFactory {

	private static int copies = 0;
	private final int copy;

	private final ConcurrentHashMap<PlayerId, OpponentModel> opponentModels = new ConcurrentHashMap<PlayerId, OpponentModel>();
	private final MCTSListener.Factory[] listeners;

	public MCTSBotFactory(MCTSListener.Factory... listeners) {
		copy = ++copies;
		this.listeners = listeners;
		StateTableEvaluator.getInstance();
	}

	public Bot createBot(final PlayerId botId, TableId tableId,
			SmartLobbyContext lobby, int buyIn, ExecutorService executor,
			BotListener... botListeners) {
		copies++;
		if (opponentModels.get(botId) == null) {
			File modelDir = new File("/home/guy/Werk/thesis/weka-3-6-0/model1/");
			Classifier preBetModel, preFoldModel, preCallModel, preRaiseModel, postBetModel, postFoldModel, postCallModel, postRaiseModel;
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(modelDir,"preBet.model")));
				preBetModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"preFold.model")));
				preFoldModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"preCall.model")));
				preCallModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"preRaise.model")));
				preRaiseModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"postBet.model")));
				postBetModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"postFold.model")));
				postFoldModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"postCall.model")));
				postCallModel = (Classifier)in.readObject();
				in.close();
				in = new ObjectInputStream(new FileInputStream(new File(modelDir,"postRaise.model")));
				postRaiseModel = (Classifier)in.readObject();
				in.close();
				WekaRegressionModel model = new WekaRegressionModel(preBetModel, preFoldModel, preCallModel, preRaiseModel, postBetModel, postFoldModel, postCallModel, postRaiseModel);
				opponentModels.put(botId, model);
			} catch (IOException e) {
				throw new IllegalStateException(e);
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException(e);
			}
		}
		SelectionStrategy selectionStrategy = new SamplingToFunctionSelector(new UCTSelector(40000));
		SelectionStrategy moveSelectionStrategy = new SampleProportionateSelector();
		return new MCTSBot(botId, tableId, lobby, executor, buyIn,
				opponentModels.get(botId),
				selectionStrategy,
				moveSelectionStrategy,
				listeners,
				botListeners);
	}

	@Override
	public String toString() {
		return "MCTS bot v1-" + copy;
	}
}